using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace TareaPDMfinal.Menus
{
    public partial class MenuModalidad : PhoneApplicationPage
    {
        public MenuModalidad()
        {
            InitializeComponent();
        }

        private void btnInsertar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Modalidades/PivotModalidadInsert.xaml?", UriKind.Relative));
        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Modalidades/PivotModalidadDelete.xaml?", UriKind.Relative));
        }

        private void btnConsultar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Modalidades/PivotModalidadConsulta.xaml?", UriKind.Relative));
        }

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Modalidades/PivotModalidadUpdate.xaml?", UriKind.Relative));
        }

        private void btnMenuPrin_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/MainPage.xaml?", UriKind.Relative));
        }
    }
}