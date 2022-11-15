package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Consultation> GetAllConsultations()
    {
        ArrayList<Consultation> lesConsultations = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT `idConsult`,`dateConsult`,`numPatient`,`numMedecin` FROM `consultation`");
            rs = ps.executeQuery();
            while (rs.next()) {
                Consultation consultation = new Consultation(rs.getInt("idConsult"), rs.getString("dateConsult"),rs.getString("numPatient"),rs.getString("numMedecin"));
                lesConsultations.add(consultation);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesConsultations;


    }
    public int getLastNumberOfConsultation()
    {

        return 0;
    }
    public void InsertConsultation(int idConsult, String dateConsultation, int numPatient,int numMedecin)
    {
        try {
            ps = cnx.prepareStatement("insert into Consultation values (?,?,?,?,?)");
            ps.setObject(1, null);
            ps.setInt(1, idConsult);
            ps.setString(2, dateConsultation);
            ps.setInt(3, numPatient);
            ps.setInt(4, numMedecin);

            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
