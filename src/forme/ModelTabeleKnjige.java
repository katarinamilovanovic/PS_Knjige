/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Knjiga;

/**
 *
 * @author kmilo
 */
public class ModelTabeleKnjige extends AbstractTableModel {

    private List<Knjiga> listaKnjiga = new ArrayList<>();
    private final String[] kolone = {"ID", "Naslov", "Autor", "ISBN", "Godina izdanja", "Zanr"};

    public ModelTabeleKnjige(List<Knjiga> listaKnjga) {
        this.listaKnjiga = listaKnjga;
    }

    @Override
    public int getRowCount() {
        return listaKnjiga.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Knjiga knjiga = listaKnjiga.get(rowIndex);
        switch (columnIndex) {
            
            case 0:
                return knjiga.getID();
            case 1:
                return knjiga.getNaslov();
            case 2:
                return knjiga.getAutor().getIme() + " " + knjiga.getAutor().getPrezime();
            case 3:
                return knjiga.getISBN();
            case 4:
                return knjiga.getGodinaIzdanja();
            case 5:
                return knjiga.getZanr();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    void osveziPodatke() {
        fireTableDataChanged();
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    
    
}
