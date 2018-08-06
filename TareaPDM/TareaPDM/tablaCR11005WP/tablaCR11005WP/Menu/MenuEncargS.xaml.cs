using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace tablaCR11005WP.Menu
{
    public partial class MenuEncargS : PhoneApplicationPage
    {
        public MenuEncargS()
        {
            InitializeComponent();
        }
        private void btnInsertar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/EncargS/PivotEncargSInsert.xaml?", UriKind.Relative));
        }
        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/EncargS/PivotEncargSDelete.xaml?", UriKind.Relative));
        }
        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/EncargS/PivotEncargSUpdate.xaml?", UriKind.Relative));
        }
        private void btnConsultar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/EncargS/PivotEncargSConsulta.xaml?", UriKind.Relative));
        }
        private void btnMenuPrin_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/MainPage.xaml?", UriKind.Relative));
        }
    }
}