/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Custom TableModel for displaying recipes in JTable
 */
//Atribut class
public class RecipeTableModel extends AbstractTableModel {
    private List<Recipe> recipes;
    private final String[] columnNames = {"ID", "Nama Resep", "Instruksi"};
//Kontroktor
    public RecipeTableModel(List<Recipe> recipes) {
        this.recipes = recipes;
    }
//Setter untuk data
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return recipes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recipe recipe = recipes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> recipe.getId();
            case 1 -> recipe.getName();
            case 2 -> recipe.getInstructions();
            default -> null;
        };
    }
}