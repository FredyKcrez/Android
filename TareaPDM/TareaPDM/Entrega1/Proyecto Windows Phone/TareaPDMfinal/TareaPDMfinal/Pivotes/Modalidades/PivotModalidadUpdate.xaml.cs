using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using System.IO;
using Windows.Storage;
using SQLite;
using TareaPDMfinal.MetodosSQLite;
using TareaPDMfinal.ClasesporTablas;

namespace TareaPDMfinal.Pivotes.Modalidad
{
    public partial class PivotModalidadUpdate : PhoneApplicationPage
    {
        public PivotModalidadUpdate()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1"); 
        
    
        private void BtnUpdate_OnClick(object sender, RoutedEventArgs e) 
        { 
            MetodosSQLiteModalidad prueba = new MetodosSQLiteModalidad();
            String res2 = prueba.Update(dbPath, editCodigo.Text, editNombre.Text); 
            txtResultado.Text = res2;
            MostrarDatos();
        } 
        
        public void MostrarDatos() 
        { 
            var db = new SQLiteConnection(dbPath); 
            var pers = db.Table<TareaPDMfinal.ClasesporTablas.Modalidad>().Where(c => c.nombmodalidad != null).ToList(); 
            listaModalidades.ItemsSource = pers; 
        }

        private void listaModalidades_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            TareaPDMfinal.ClasesporTablas.Modalidad items = (TareaPDMfinal.ClasesporTablas.Modalidad)listaModalidades.SelectedItem;
            editCodigo.Text = items.codmodalidad; 
            editNombre.Text = items.nombmodalidad; 
            pivotPrincipal.SelectedItem = itemUpdate;
        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e) 
        { 
            editCodigo.Text = String.Empty; 
            editNombre.Text = String.Empty; 
            txtResultado.Text = String.Empty; 
        }

        private void BtnMenu_OnClick(object sender, RoutedEventArgs e) 
        { 
            NavigationService.Navigate(new Uri("/Menus/MenuModalidad.xaml?", UriKind.Relative)); 
        }
    }
}