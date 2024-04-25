package dk.sdu.pa2.task3;

import dk.sdu.pa2.task2.HealthComparator;
import dk.sdu.pa2.task2.Pokemon;
import dk.sdu.pa2.task2.PokemonReader;
import dk.sdu.pa2.task2.PokemonType;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PrimaryController {
    @FXML
    private ChoiceBox<PokemonType> choiceBox;
    @FXML
    private ImageView imageView1, imageView2, imageView3;
    @FXML
    private Label name1, name2, name3;
    @FXML
    private Label health1, health2, health3;
    @FXML
    private Label attack1, attack2, attack3;
    @FXML
    private Label defense1, defense2, defense3;

    private File file = new File("pokemon.csv");

    private List<Pokemon> pokemonList;
    private Map<PokemonType, List<Pokemon>> pokemonMap;

    @FXML
    public void initialize(){
        PokemonReader pokemonReader = new PokemonReader();
        pokemonList = (pokemonReader.readFromFile(file));
        pokemonList.sort(null);
        pokemonMap = pokemonReader.mapPokemon(pokemonList);
        choiceBox.getItems().addAll(PokemonType.values());
    }

    public void updatePokemon() throws URISyntaxException {
        PokemonType selection = choiceBox.getSelectionModel().getSelectedItem();
        Pokemon pokemon = pokemonMap.get(selection).get(0);
        Pokemon pokemon2 = pokemonMap.get(selection).get(1);
        Pokemon pokemon3 = pokemonMap.get(selection).get(2);

        name1.setText(pokemon.getName());
        name2.setText(pokemon2.getName());
        name3.setText(pokemon3.getName());

        health1.setText(Integer.toString(pokemon.getHealth()));
        health2.setText(Integer.toString(pokemon2.getHealth()));
        health3.setText(Integer.toString(pokemon3.getHealth()));

        attack1.setText(Integer.toString(pokemon.getAttack()));
        attack2.setText(Integer.toString(pokemon2.getAttack()));
        attack3.setText(Integer.toString(pokemon3.getAttack()));

        defense1.setText(Integer.toString(pokemon.getDefense()));
        defense2.setText(Integer.toString(pokemon2.getDefense()));
        defense3.setText(Integer.toString(pokemon3.getDefense()));

        imageView1.setImage(new Image(getClass().getResource("pokemon_images/" + pokemon.getImage()).toURI().toString()));
        imageView2.setImage(new Image(getClass().getResource("pokemon_images/" + pokemon2.getImage()).toURI().toString()));
        imageView3.setImage(new Image(getClass().getResource("pokemon_images/" + pokemon3.getImage()).toURI().toString()));
    }
}