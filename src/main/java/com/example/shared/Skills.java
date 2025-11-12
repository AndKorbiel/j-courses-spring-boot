package com.example.shared;

public enum Skills {
  ENGLISH("English"),
  MATH("Math"),
  MUSCI("Music");

  private String name;

  Skills(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
