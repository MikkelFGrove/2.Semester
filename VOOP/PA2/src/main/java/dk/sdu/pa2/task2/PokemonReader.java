package dk.sdu.pa2.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PokemonReader {
    public List<Pokemon> readFromFile(File file) {
        List<Pokemon> pokemons = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String[] stringArray = scanner.nextLine().split(",");
                pokemons.add(new Pokemon(Integer.parseInt(stringArray[0]) ,stringArray[1],stringArray[2],PokemonType.valueOf(stringArray[3]) , Integer.parseInt(stringArray[4]),Integer.parseInt(stringArray[5]),Integer.parseInt(stringArray[6])));

            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        return pokemons;

    }


    public Map<PokemonType, List<Pokemon>> mapPokemon(List<Pokemon> pokemonList) {
        Map<PokemonType, List<Pokemon>> pokemonMap = new HashMap<>();
        ArrayList<String> pokemonTNumber = new ArrayList<>();

        for (int i = 0; pokemonList.size() > i; i++){
            if(!pokemonMap.containsKey(pokemonList.get(i).getType())){
                ArrayList<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemonList.get(i));
                pokemonMap.put(pokemonList.get(i).getType(), pokemons);
            } else{
                pokemonMap.get(pokemonList.get(i).getType()).add(pokemonList.get(i));
            }
        }
        return pokemonMap;
    }

}
