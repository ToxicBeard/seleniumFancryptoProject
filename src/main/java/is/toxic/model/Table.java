package is.toxic.model;

import io.vavr.CheckedFunction0;
import static io.vavr.control.Try.of;
import lombok.Builder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Builder
public class Table {
    private final WebElement table;

    public List<WebElement> getRows() {
        return table.findElements(By.xpath(".//tbody//tr"));

    }

    public List<String> getHeads() {
        return of((CheckedFunction0<ArrayList<String>>) ArrayList::new)
                .andThen(resultList -> table
                        .findElement(By.cssSelector("thead > tr"))
                        .findElements(By.xpath("./th"))
                        .forEach(element -> resultList.add(element.getText())))
                .get();
    }

    public List<List<WebElement>> getRowsWithColumns() {
        return of((CheckedFunction0<List<List<WebElement>>>) ArrayList::new)
                .andThen(list -> getRows()
                        .forEach(row -> list.add(row.findElements(By.xpath("./td")))))
                .get();
    }

    public List<Map<String, WebElement>> getRowsWithHeadingColumns() {
        return of((CheckedFunction0<List<Map<String, WebElement>>>) ArrayList::new)
                .andThen(resultList -> resultList.add(
                        of((CheckedFunction0<Map<String, WebElement>>) LinkedHashMap::new)
                                .andThen(StringElementMap ->
                                        getRowsWithColumns().forEach(
                                                row -> row.forEach(
                                                        column -> getHeads().forEach(
                                                                heading -> StringElementMap.put(heading, column)
                                                        )))
                                ).get()
                )).get();
    }

    public WebElement getValueFromCell(int row, int column) {
        return getRowsWithColumns()
                .get(row - 1)
                .get(column - 1);
    }

    public WebElement getValueFromName(int row, String name) {
        return getRowsWithHeadingColumns()
                .get(row)
                .get(name);
    }

    public int getRowsCount() {
        return getRows().size() + 1;
    }

    public int getColumnsCount() {
        return getHeads().size() + 1;
    }
}
