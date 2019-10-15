package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Food;

/**
 * Panel containing the list of persons.
 */
public class FoodListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(FoodListPanel.class);

    @FXML
    private ListView<Food> personListView;

    public FoodListPanel(ObservableList<Food> personList) {
        super(FXML);
        personListView.setItems(personList);
        personListView.setCellFactory(listView -> new FoodListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class FoodListViewCell extends ListCell<Food> {
        @Override
        protected void updateItem(Food person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new FoodCard(person, getIndex() + 1).getRoot());
            }
        }
    }

}
