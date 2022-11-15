package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedecin
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedecin() {
        cnx = ConnexionBDD.getCnx();
    }

    public <Medecin> ArrayList<String> getAllMedecins()
    {

        ArrayList<String> lesMedecins = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT `nomMedecin` FROM `medecin` ");
            rs = ps.executeQuery();
            while (rs.next()) {
                String nomMedecin = rs.getString("nomMedecin");


            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedecins;


    }

    public int getIdMedecinByName(String nomMed)
    {

        return 0;
    }
}
