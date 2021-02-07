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
    public partial class FrmMenu : Form
    {
        public FrmMenu()
        {
            InitializeComponent();
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            OuvrirFenetreDeConnexion();
        }

        private void FrmMenu_FormClosed(object sender, FormClosedEventArgs e)
        {
            OuvrirFenetreDeConnexion();
        }

        public void OuvrirFenetreDeConnexion()
        {
            FrmConnexion frmConnexion = new FrmConnexion();
            frmConnexion.Show();
            this.Hide();
        }

        private void créerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LoadFormCreerClasse();
        }
        private void LoadFormCreerClasse()
        {
            EffacerFormFils();
            Form1 frmCreerClasse = new Form1();
            frmCreerClasse.MdiParent = this;
            frmCreerClasse.Show();
        }

        private void inscriptionToolStripMenuItem_Click(object sender, EventArgs e)
        {
            EffacerFormFils();
            FrmInscription frmInscription = new FrmInscription();
            frmInscription.MdiParent = this;
            frmInscription.Show();
        }

        private void LoadFormInscription()
        {
            
        }

        private void EffacerFormFils()
        {
            foreach (Form form in this.MdiChildren)
            {
                form.Close();
            }
        }

        private void FrmMenu_Load(object sender, EventArgs e)
        {
            LoadFormCreerClasse();
            
        }

        private void attribuerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            EffacerFormFils();
            FrmProfesseur frmInscription = new FrmProfesseur();
            frmInscription.MdiParent = this;
            frmInscription.Show();
        }

        private void classeProfesseurToolStripMenuItem_Click(object sender, EventArgs e)
        {
            EffacerFormFils();
            FrmListerProfesseur frmInscription = new FrmListerProfesseur();
            frmInscription.MdiParent = this;
            frmInscription.Show();
        }
    }
}
