package com.ablo.dtos;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto {

    @NotNull(message = "The number of bags is required.")
    @Min(value = 1, message = "The number of bag must be greater than 1 or equal to 1")
    @Max(value = 3, message = "The number of bag must not be greater than 3.")
    private int bagsCount;

    @NotNull(message = "The date of arrival is required")
    @FutureOrPresent(message = "The date of arrival must be today or in the future.")
    private Date arrivalDate;

    @NotNull(message = "The date of departure is required")
    @FutureOrPresent(message = "The date of departure must be today or in the future.")
    private Date departureDate;

    @NotNull(message = "The number of room is required.")
    @Positive(message = "The room's number must be greater than 0.")
    private int roomNumber;

    @NotNull(message = "The extras is required.")
    @NotEmpty(message = "The extras is required.")
    private String extras;

    @NotNull(message = "The user id is required.")
    @Positive(message = "The user id must be greater than 0.")
    private int userId;

    private String note;
}
