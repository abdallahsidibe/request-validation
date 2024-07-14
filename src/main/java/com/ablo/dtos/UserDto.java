package com.ablo.dtos;

import com.ablo.enums.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Data
public class UserDto {

    @NotEmpty(message = "The full name is required.") // Pas null ET longueur > 0
    @Size(min = 2, max = 100, message = "The lenght of full name must be between 2 and 100 characters.")
    private String fullName;

    @Email(message = "The email is invalid", flags = {Flag.CASE_INSENSITIVE})
    private String email;

    @NotNull(message = "The birth date is required") // Pas null
    @Past(message = "date of birth must be in the past ")
    private Date birthDate;

    @NotEmpty(message = "The gender is required.")
    private Gender gender;

    @Valid
    @NotNull(message = " The address is required.")
    private AddressDto address;
}
