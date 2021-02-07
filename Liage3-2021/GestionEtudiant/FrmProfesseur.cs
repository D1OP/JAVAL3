using GestionEtudiant.services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GestionEtudiant
{
    public partial class FrmProfesseur : Form
    {

        private Service metier = new Service();

        public FrmProfesseur()
        {
            InitializeComponent();
        }

        private void FrmProfesseur_Load(object sender, EventArgs e)
        {
            cmbClasse.DataSource = metier.ListerClasse();
            cmbClasse.DisplayMember = "libelle";
            cmbClasse.ValueMember = "id";
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }
    }
}
