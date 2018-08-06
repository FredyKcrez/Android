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
    public partial class MenuAlumno : PhoneApplicationPage
    {
        public MenuAlumno()
        {
            InitializeComponent();
        }
        private void btnInsertar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivots/Alumnos/PivotAlumnoInsert.xaml?",
           UriKind.Relative));
        }
        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivots/Alumnos/PivotAlumnoDelete.xaml?",
           UriKind.Relative));
        }

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivots/Alumnos/PivotAlumnoUpdate.xaml?",
           UriKind.Relative));
        }
        private void btnConsultar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new
           Uri("/Pivots/Alumnos/PivotAlumnoConsulta.xaml?", UriKind.Relative));
        }
        private void btnMenuPrin_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/MainPage.xaml?", UriKind.Relative));
        } 
    }
}