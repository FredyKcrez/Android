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
    public partial class MenuEspecialidad : PhoneApplicationPage
    {
        public MenuEspecialidad()
        {
            InitializeComponent();
        }

        private void btnInsertar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Especialidades/PivotEspecialidadInsert.xaml?", UriKind.Relative));
        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Especialidades/PivotEspecialidadDelete.xaml?", UriKind.Relative));
        }

        private void btnConsultar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Especialidades/PivotEspecialidadConsulta.xaml?", UriKind.Relative));
        }

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Pivotes/Especialidades/PivotEspecialidadUpdate.xaml?", UriKind.Relative));
        }

        private void btnMenuPrin_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/MainPage.xaml?", UriKind.Relative));
        }
    }
}