package com.codecool.battleofcards;

import java.util.List;

public interface CardDAO<T> {
    List<T> getAllCards();
}