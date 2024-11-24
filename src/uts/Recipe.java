/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts;

/**
 * Model class Tambah Resep makanan
 * @author ASUS
 */
//atribut
public class Recipe {
    private int id;
    private String name;
    private String instructions;
//kontruktor (membuat objek)
    public Recipe(int id, String name, String instructions) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
    }
//getter (Mengambil Nilai Atribut dan setter Mengubah Nilai Atribut) 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}