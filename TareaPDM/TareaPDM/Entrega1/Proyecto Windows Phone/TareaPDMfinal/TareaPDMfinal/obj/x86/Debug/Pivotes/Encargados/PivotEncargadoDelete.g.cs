﻿#pragma checksum "C:\Users\Luis Morales\documents\visual studio 2012\Projects\TareaPDMfinal\TareaPDMfinal\Pivotes\Encargados\PivotEncargadoDelete.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "B86C347D1B94A76700F541488B7FABFC"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.34014
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using Microsoft.Phone.Controls;
using System;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Automation.Peers;
using System.Windows.Automation.Provider;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Interop;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Resources;
using System.Windows.Shapes;
using System.Windows.Threading;


namespace TareaPDMfinal.Pivotes.Encargados {
    
    
    public partial class PivotEncargadoDelete : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal Microsoft.Phone.Controls.Pivot pivotPrincipal;
        
        internal Microsoft.Phone.Controls.PivotItem itemDelete;
        
        internal System.Windows.Controls.TextBox editCodigo;
        
        internal System.Windows.Controls.TextBox editNombre;
        
        internal System.Windows.Controls.TextBox editApellido;
        
        internal System.Windows.Controls.TextBox editCorreo;
        
        internal System.Windows.Controls.RadioButton radioHombre;
        
        internal System.Windows.Controls.RadioButton radioMujer;
        
        internal System.Windows.Controls.Button btnDelete;
        
        internal System.Windows.Controls.Button btnLimpiar;
        
        internal System.Windows.Controls.TextBlock txtResultado;
        
        internal System.Windows.Controls.Button btnMenu;
        
        internal Microsoft.Phone.Controls.LongListSelector listaEncargados;
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Windows.Application.LoadComponent(this, new System.Uri("/TareaPDMfinal;component/Pivotes/Encargados/PivotEncargadoDelete.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.pivotPrincipal = ((Microsoft.Phone.Controls.Pivot)(this.FindName("pivotPrincipal")));
            this.itemDelete = ((Microsoft.Phone.Controls.PivotItem)(this.FindName("itemDelete")));
            this.editCodigo = ((System.Windows.Controls.TextBox)(this.FindName("editCodigo")));
            this.editNombre = ((System.Windows.Controls.TextBox)(this.FindName("editNombre")));
            this.editApellido = ((System.Windows.Controls.TextBox)(this.FindName("editApellido")));
            this.editCorreo = ((System.Windows.Controls.TextBox)(this.FindName("editCorreo")));
            this.radioHombre = ((System.Windows.Controls.RadioButton)(this.FindName("radioHombre")));
            this.radioMujer = ((System.Windows.Controls.RadioButton)(this.FindName("radioMujer")));
            this.btnDelete = ((System.Windows.Controls.Button)(this.FindName("btnDelete")));
            this.btnLimpiar = ((System.Windows.Controls.Button)(this.FindName("btnLimpiar")));
            this.txtResultado = ((System.Windows.Controls.TextBlock)(this.FindName("txtResultado")));
            this.btnMenu = ((System.Windows.Controls.Button)(this.FindName("btnMenu")));
            this.listaEncargados = ((Microsoft.Phone.Controls.LongListSelector)(this.FindName("listaEncargados")));
        }
    }
}

