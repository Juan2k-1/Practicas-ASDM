/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Pedido;
import Modelo.PedidoConcreto;
import Modelo.Pizza;
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
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author juald
 */
public class ControladorPrincipal implements ActionListener {

    private VistaPrincipal vPrincipal = null;
    private VistaPorDefecto vPorDefecto = null;
    private VistaPizzas vPizzas = null;
    private VistaMensaje vMensaje = null;
    private VistaPedido vPedido = null;
    private ArrayList<Pizza> pizzas;
    private Pizza pizza;
    private Pedido miFabrica;
    private String tipoPizza;

    public ControladorPrincipal(VistaLogin vLogin, VistaMensaje vMensaje) {

        this.vPrincipal = new VistaPrincipal();
        this.vPorDefecto = new VistaPorDefecto();
        this.vPizzas = new VistaPizzas();
        this.vPedido = new VistaPedido();
        this.vMensaje = vMensaje;
        this.pizzas = new ArrayList<>();

        addListeners();

        this.vPrincipal.setLayout(new CardLayout());

        this.vPrincipal.add(vPorDefecto);
        this.vPrincipal.add(vPedido);

        this.vPorDefecto.setVisible(true);
        this.vPizzas.setVisible(false);
        this.vPedido.setVisible(false);

        this.vPrincipal.setTitle("Práctica 2 - ASDM - Pizzas web - Juan Alberto Domínguez Vázquez");
        this.vPrincipal.setLocationRelativeTo(null); //Para que la ventana se muestre en el centro de la pantalla
        this.vPrincipal.setVisible(true); // Para hacer la ventana visible
        this.vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que la ventana se cierra cuando le doy a cerrar
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

    /**
     *
     * @param e
     */
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
                try {
                    this.tipoPizza = (String) this.vPizzas.TipoPizza.getSelectedItem();
                    this.miFabrica = new PedidoConcreto(tipoPizza);
                    this.pizza = miFabrica.factoryMethod();

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
                } catch (NullPointerException ex) {
                    //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    this.vMensaje.MensajeDeError("No ha seleccionado ninguna pizza, por favor, seleccione una");
                }
                break;
            }
            case "Salir2": {
                this.vPizzas.dispose();
                break;
            }
        }
    }

    /**
     *
     * @return 
     */
    public boolean hacerPedido() {
        int numIngredientes = 0;
        boolean resultado = false;

        String tipoPizza = (String) this.vPizzas.TipoPizza.getSelectedItem();
        boolean aceitunasNegrasSeleccionadas = this.vPizzas.AceitunasNegras.isSelected();
        boolean anchoasSeleccionadas = this.vPizzas.Anchoas.isSelected();
        boolean baconSeleccionado = this.vPizzas.Bacon.isSelected();
        boolean extraQuesoSeleccionado = this.vPizzas.ExtraQueso.isSelected();
        boolean jamonYorkSeleccionado = this.vPizzas.JamonYork.isSelected();
        boolean polloBraseadoSeleccionado = this.vPizzas.PolloBraseado.isSelected();

        if (aceitunasNegrasSeleccionadas) {
            numIngredientes++;
            this.pizza.añadirIngrediente("Aceitunas negras");
        }
        if (anchoasSeleccionadas) {
            numIngredientes++;
            this.pizza.añadirIngrediente("Anchoas");
        }
        if (baconSeleccionado) {
            numIngredientes++;
            this.pizza.añadirIngrediente("Bacon");
        }
        if (extraQuesoSeleccionado) {
            numIngredientes++;
            this.pizza.añadirIngrediente("Extra de queso");
        }
        if (jamonYorkSeleccionado) {
            numIngredientes++;
            this.pizza.añadirIngrediente("Jamón York");
        }
        if (polloBraseadoSeleccionado) {
            numIngredientes++;
            this.pizza.añadirIngrediente("Pollo braseado");
        }
        if (numIngredientes <= 3 || numIngredientes == 0) {
            this.pizzas.add(pizza);
            this.vPedido.Pizza.setText(tipoPizza);

            for (int i = 0; i < this.pizza.getIngredientes().size(); i++) {
                this.vPedido.IngredientesExtras.setText(this.pizza.getIngredientes().toString());
                System.out.println(this.pizza.getIngredientes().get(i).toString());
            }
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }
}
