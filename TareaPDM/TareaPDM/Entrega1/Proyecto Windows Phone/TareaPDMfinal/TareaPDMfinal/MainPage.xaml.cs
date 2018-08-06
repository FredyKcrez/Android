﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using TareaPDMfinal.Resources;

namespace TareaPDMfinal
{
    public partial class MainPage : PhoneApplicationPage
    {
        // Constructor
        public MainPage()
        {
            InitializeComponent();

            // Código de ejemplo para traducir ApplicationBar
            //BuildLocalizedApplicationBar();
        }

        private void btnTablaModalidad_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuModalidad.xaml?", UriKind.Relative));
        }

        private void btnTablaEncargado_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuEncargado.xaml?", UriKind.Relative));
        }

        private void btnTablaProyecto_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuProyecto.xaml?", UriKind.Relative));
        }

        private void btnTablaTipoProyecto_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuTipoProyecto.xaml", UriKind.Relative));
        }

        private void btnTablaEspecialidad_Click_1(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuEspecialidad.xaml", UriKind.Relative));
        }

        // Código de ejemplo para compilar una ApplicationBar traducida
        //private void BuildLocalizedApplicationBar()
        //{
        //    // Establecer ApplicationBar de la página en una nueva instancia de ApplicationBar.
        //    ApplicationBar = new ApplicationBar();

        //    // Crear un nuevo botón y establecer el valor de texto en la cadena traducida de AppResources.
        //    ApplicationBarIconButton appBarButton = new ApplicationBarIconButton(new Uri("/Assets/AppBar/appbar.add.rest.png", UriKind.Relative));
        //    appBarButton.Text = AppResources.AppBarButtonText;
        //    ApplicationBar.Buttons.Add(appBarButton);

        //    // Crear un nuevo elemento de menú con la cadena traducida de AppResources.
        //    ApplicationBarMenuItem appBarMenuItem = new ApplicationBarMenuItem(AppResources.AppBarMenuItemText);
        //    ApplicationBar.MenuItems.Add(appBarMenuItem);
        //}
    }
}