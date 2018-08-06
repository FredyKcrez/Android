using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace cr11005SQLiteWP8.Menus
{
    public partial class MenuNota : PhoneApplicationPage
    {
        public MenuNota()
        {
            InitializeComponent();
        }
        private void btnInsertar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivots/Notas/PivotNotaInsert.xaml?", UriKind.Relative));
        }
        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivots/Notas/PivotNotaDelete.xaml?", UriKind.Relative));
        }
        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivots/Notas/PivotNotaUpdate.xaml?", UriKind.Relative));
        }
        private void btnConsultar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivots/Notas/PivotNotaConsulta.xaml?", UriKind.Relative));
        }
        private void btnMenuPrin_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/MainPage.xaml?", UriKind.Relative));
        }
    }
}