/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sisrae;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;


/**
 *
 * @author Oz44
 */
public class CriteriosEvaluacion extends JPanel implements ItemListener{
 JPanel comboBoxPane = new JPanel();
 JPanel Cards = new JPanel(new CardLayout());
 JPanel individual = new JPanel();
 JPanel global = new JPanel();
 JPanel evento = new JPanel();
 
 
    public CriteriosEvaluacion() {
        
        String comboBoxItems[] = { "individual", "global" };
        JComboBox eventocb = new JComboBox(comboBoxItems);
        eventocb.setEditable(false);
        eventocb.addItemListener(this);
        evento.add(eventocb);
        
        
       /* individual.setLayout(new BoxLayout(individual,BoxLayout.PAGE_AXIS));
        global.setLayout(new BoxLayout(global,BoxLayout.PAGE_AXIS));*/
       
        individual.add(new Checkbox("Hora de Entrada"));
        individual.add(new Checkbox("Hora de Salida"));
        individual.add(new Checkbox("Calificacion"));
        
        global.add(new Checkbox("Asistencia a Todo"));
        global.add(new Checkbox("Asistencia C.Obligatorias"));
        global.add(new Checkbox("Asistencia T.Obligatorios"));
        global.add(new Checkbox("Calificacion Promedio"));
        
        Cards = new JPanel(new CardLayout());
        Cards.add(individual, "individual");
        Cards.add(global,"global" );
        
        this.add(evento);
        this.add(Cards);
        
        
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        System.out.println((String)evt.getItem());
        CardLayout cl = (CardLayout)(Cards.getLayout());
        cl.show(Cards, (String)evt.getItem());
    }
   
    
}
