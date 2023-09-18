/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConExtraAceitunasNegras;
import Modelo.ConExtraAnchoas;
import Modelo.ConExtraBacon;
import Modelo.ConExtraJamon;
import Modelo.ConExtraPollo;
import Modelo.ConExtraQueso;
import Modelo.Pizza;
import Modelo.PizzaBarbacoa;
import Modelo.PizzaCuatroQuesos;
import Modelo.PizzaMarinera;
import Modelo.PizzaPeperoni;
import Vista.VistaLogin;
import Vista.VistaMensaje;
import Vista.VistaPedido;
import Vista.VistaPizzas;
import Vista.VistaPorDefecto;
import Vista.VistaPrincipal;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author juald
 */
public class ControladorPrincipal implements ActionListener {

    private VistaLogin vLogin;
    private VistaPrincipal vPrincipal;
    private VistaMensaje vMensaje;
    private VistaPorDefecto vPorDefecto;
    private VistaPizzas vPizzas;
    private VistaPedido vPedido;
    private String tipoPizza;
    private Pizza pizza;

    public ControladorPrincipal(VistaLogin vLogin, VistaMensaje vMensaje) {
        this.vLogin = vLogin;
        this.vPrincipal = new VistaPrincipal();
        this.vPizzas = new VistaPizzas();
        this.vPedido = new VistaPedido();
        this.vMensaje = vMensaje;
        this.vPorDefecto = new VistaPorDefecto();

        addListeners();

        this.vPrincipal.setLayout(new CardLayout());
        this.vPrincipal.add(this.vPorDefecto);
        this.vPrincipal.add(this.vPedido);
        
        this.vPorDefecto.setVisible(true);
        this.vPizzas.setVisible(false);
        this.vPedido.setVisible(false);

        this.vPrincipal.setTitle("Práctica 8 - ASDM - Pizzas web - Juan Alberto Domínguez Vázquez");
        this.vPrincipal.setLocationRelativeTo(null); //Para que la ventana se muestre en el centro de la pantalla
        this.vPrincipal.setVisible(true); // Para hacer la ventana visible
        this.vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que la ventana se cierra cuando le doy a cerrar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "GestionPizzas": {
                this.vPorDefecto.setVisible(false);
                this.vPizzas.setLocationRelativeTo(null);
                this.vPizzas.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vPizzas.setVisible(true);
                break;
            }
            case "Salir": {
                this.vPrincipal.dispose();
                System.exit(0);
                break;
            }
            case "HacerPedido": {
                boolean resultado = hacerPedido();
                if (resultado) {
                    this.vMensaje.MensajeInformacion("¡Pedido realizado con éxito!");
                    this.vPizzas.dispose();
                    this.vPorDefecto.setVisible(false);
                    this.vPedido.setVisible(true);
                } else {
                    this.vMensaje.MensajeDeError("Error, ha seleccionado más de 3 ingredientes extra");
                    this.vPizzas.AceitunasNegras.setSelected(false);
                    this.vPizzas.Anchoas.setSelected(false);
                    this.vPizzas.Bacon.setSelected(false);
                    this.vPizzas.ExtraQueso.setSelected(false);
                    this.vPizzas.JamonYork.setSelected(false);
                    this.vPizzas.PolloBraseado.setSelected(false);
                }
                this.vPizzas.TipoPizza.setSelectedIndex(-1);
                this.vPizzas.AceitunasNegras.setSelected(false);
                this.vPizzas.Anchoas.setSelected(false);
                this.vPizzas.Bacon.setSelected(false);
                this.vPizzas.ExtraQueso.setSelected(false);
                this.vPizzas.JamonYork.setSelected(false);
                this.vPizzas.PolloBraseado.setSelected(false);
                break;
            }
            case "Salir2": {
                this.vPizzas.dispose();
                break;
            }
        }
    }

    public boolean hacerPedido() {
        int numIngredientes = 0;
        boolean resultado = false;
        this.tipoPizza = (String) this.vPizzas.TipoPizza.getSelectedItem();

        if (this.tipoPizza.equals("Peperoni")) {
            this.pizza = new PizzaPeperoni();
        } else if (this.tipoPizza.equals("Marinera")) {
            this.pizza = new PizzaMarinera();
        } else if (this.tipoPizza.equals("Barbacoa")) {
            this.pizza = new PizzaBarbacoa();
        } else {
            this.pizza = new PizzaCuatroQuesos();
        }

        boolean aceitunasNegrasSeleccionadas = this.vPizzas.AceitunasNegras.isSelected();
        boolean anchoasSeleccionadas = this.vPizzas.Anchoas.isSelected();
        boolean baconSeleccionado = this.vPizzas.Bacon.isSelected();
        boolean extraQuesoSeleccionado = this.vPizzas.ExtraQueso.isSelected();
        boolean jamonYorkSeleccionado = this.vPizzas.JamonYork.isSelected();
        boolean polloBraseadoSeleccionado = this.vPizzas.PolloBraseado.isSelected();

        if (aceitunasNegrasSeleccionadas) {
            numIngredientes++;
            this.pizza = new ConExtraAceitunasNegras(this.pizza);
        }
        if (anchoasSeleccionadas) {
            numIngredientes++;
            this.pizza = new ConExtraAnchoas(this.pizza);
        }
        if (baconSeleccionado) {
            numIngredientes++;
            this.pizza = new ConExtraBacon(this.pizza);
        }
        if (extraQuesoSeleccionado) {
            numIngredientes++;
            this.pizza = new ConExtraQueso(this.pizza);
        }
        if (jamonYorkSeleccionado) {
            numIngredientes++;
            this.pizza = new ConExtraJamon(this.pizza);
        }
        if (polloBraseadoSeleccionado) {
            numIngredientes++;
            this.pizza = new ConExtraPollo(this.pizza);
        }
        if (numIngredientes <= 3 || numIngredientes == 0) {
            //this.pizzas.add(pizza);
            this.vPedido.Pizza.setText(this.tipoPizza);
            this.vPedido.IngredientesExtras.setText(this.pizza.getIngredientes());
            this.vPedido.CampoFormaPreparacion.setText(this.pizza.getFormaPreparacion());
            this.vPedido.CampoCoste.setText(String.valueOf(this.pizza.getCoste()));
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    private void addListeners() {
        this.vPrincipal.GestionPizzas.addActionListener(this);
        this.vPrincipal.Salir.addActionListener(this);
        this.vPizzas.TipoPizza.addActionListener(this);
        this.vPizzas.HacerPedido.addActionListener(this);
        this.vPizzas.Salir.addActionListener(this);
        this.vPizzas.AceitunasNegras.addActionListener(this);
        this.vPizzas.Anchoas.addActionListener(this);
        this.vPizzas.Bacon.addActionListener(this);
        this.vPizzas.ExtraQueso.addActionListener(this);
        this.vPizzas.JamonYork.addActionListener(this);
        this.vPizzas.PolloBraseado.addActionListener(this);
        this.vPedido.Salir.addActionListener(this);
    }
}
