﻿#pragma checksum "C:\Users\Luis Morales\documents\visual studio 2012\Projects\TareaPDMfinal\TareaPDMfinal\Pivotes\Proyectos\PivotProyectoConsulta.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "C9576FC2452D76F4521C328D2AB6FFE6"
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


namespace TareaPDMfinal.Pivotes.Proyectos {
    
    
    public partial class PivotProyectoConsulta : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal Microsoft.Phone.Controls.Pivot pivotPrincipal;
        
        internal Microsoft.Phone.Controls.PivotItem itemConsulta;
        
        internal System.Windows.Controls.TextBox editCodigop;
        
        internal System.Windows.Controls.TextBox editCodigoe;
        
        internal System.Windows.Controls.TextBox editEntidad;
        
        internal System.Windows.Controls.TextBox editTipo;
        
        internal System.Windows.Controls.TextBox editNombrep;
        
        internal System.Windows.Controls.TextBox editCantidad;
        
        internal System.Windows.Controls.Button btnConsulta;
        
        internal System.Windows.Controls.Button btnLimpiar;
        
        internal System.Windows.Controls.TextBlock txtResultado;
        
        internal System.Windows.Controls.Button btnMenu;
        
        internal Microsoft.Phone.Controls.LongListSelector listaProyectos;
        
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
            System.Windows.Application.LoadComponent(this, new System.Uri("/TareaPDMfinal;component/Pivotes/Proyectos/PivotProyectoConsulta.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.pivotPrincipal = ((Microsoft.Phone.Controls.Pivot)(this.FindName("pivotPrincipal")));
            this.itemConsulta = ((Microsoft.Phone.Controls.PivotItem)(this.FindName("itemConsulta")));
            this.editCodigop = ((System.Windows.Controls.TextBox)(this.FindName("editCodigop")));
            this.editCodigoe = ((System.Windows.Controls.TextBox)(this.FindName("editCodigoe")));
            this.editEntidad = ((System.Windows.Controls.TextBox)(this.FindName("editEntidad")));
            this.editTipo = ((System.Windows.Controls.TextBox)(this.FindName("editTipo")));
            this.editNombrep = ((System.Windows.Controls.TextBox)(this.FindName("editNombrep")));
            this.editCantidad = ((System.Windows.Controls.TextBox)(this.FindName("editCantidad")));
            this.btnConsulta = ((System.Windows.Controls.Button)(this.FindName("btnConsulta")));
            this.btnLimpiar = ((System.Windows.Controls.Button)(this.FindName("btnLimpiar")));
            this.txtResultado = ((System.Windows.Controls.TextBlock)(this.FindName("txtResultado")));
            this.btnMenu = ((System.Windows.Controls.Button)(this.FindName("btnMenu")));
            this.listaProyectos = ((Microsoft.Phone.Controls.LongListSelector)(this.FindName("listaProyectos")));
        }
    }
}

