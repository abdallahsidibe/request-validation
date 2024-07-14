package com.ablo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Data;

@Data
public class AddressDto {

    // NotBlank inclut NotEmpty et NotNull
    @NotBlank(message = "The country is required.") // pas null, pas vide, ni composés uniquement d'espaces
    private String country;

    @NotBlank(message = "The city is required.")//n'est pas null, vide ou composé uniquement d'espaces blancs
    private String city;

    @NotBlank(message = "The zip code is required.")
    @Pattern(regexp = "^\\d{1,5}$", flags = {Flag.CASE_INSENSITIVE, Flag.MULTILINE}, message = " The zip code is invalid.")
    private String zipCode;

    @NotBlank(message = "The street is required.")
    private String street;

    private String state;

    /**
     * ^: Garantit que le code postal commence au début de la chaîne d'entrée.
     * \d: Correspond à n'importe quel chiffre unique (0-9), ce qui permet aux codes postaux de ne se composer que de caractères numériques.
     * {1,5}: Spécifie que le chiffre précédent peut être répété une à cinq fois. Cela permet des codes postaux de longueurs variables entre 1 et 5 chiffres.
     * $: Garantit que le code postal se termine à la fin de la chaîne d'entrée, empêchant les caractères supplémentaires au-delà du format de code postal valide.
     */
}
