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
    public partial class MenuEncargado : PhoneApplicationPage
    {
        public MenuEncargado()
        {
            InitializeComponent();
        }

        private void btnInsertar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Encargados/PivotEncargadoInsert.xaml?", UriKind.Relative));
        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Encargados/PivotEncargadoDelete.xaml?", UriKind.Relative));
        }

        private void btnConsultar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Encargados/PivotEncargadoConsulta.xaml?", UriKind.Relative));
        }

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Encargados/PivotEncargadoUpdate.xaml?", UriKind.Relative));
        }

        private void btnMenuPrin_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/MainPage.xaml?", UriKind.Relative));
        }
    }
}