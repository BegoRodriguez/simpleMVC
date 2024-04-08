package org.example;

import org.example.ConversorMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMonedaController {
    private ConversorMoneda model;
    private JFrame view;

    public ConversorMonedaController(ConversorMoneda model, JFrame view) {
        this.model = model;
        this.view = view;

        JButton convertirApesetas = new JButton("Convertir a pesetas");
        JButton convertirAeuros = new JButton("Convertir a euros");

        convertirApesetas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cantidadEuros = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad en euros:"));
                double resultadoPesetas = model.eurosAPesetas(cantidadEuros);
                JOptionPane.showMessageDialog(null, "Resultado: " + resultadoPesetas + " pesetas");
            }
        });

        convertirAeuros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cantidadPesetas = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad en pesetas:"));
                double resultadoEuros = model.pesetasAEuros(cantidadPesetas);
                JOptionPane.showMessageDialog(null, "Resultado: " + resultadoEuros + " euros");
            }
        });

        JPanel botonera = new JPanel();
        botonera.add(convertirApesetas);
        botonera.add(convertirAeuros);

        view.add(botonera, BorderLayout.SOUTH);
        //view.getContentPane().add(view);
    }

    public static void main(String[] args) {
        ConversorMoneda model = new ConversorMoneda();
        JFrame view = new JFrame("Conversor de Moneda");
        new ConversorMonedaController(model, view);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}