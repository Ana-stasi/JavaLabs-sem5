// Rotating an array using C#
// http://www.cyotek.com/blog/rotating-an-array-using-csharp

using System;
using System.Diagnostics;
using System.Windows.Forms;

namespace CyotekDotComRotateArrayDemo
{
  internal partial class MainForm : Form
  {
    #region Constructors

    public MainForm()
    {
      this.InitializeComponent();
    }

    #endregion

    #region Methods

    /// <summary>
    /// Raises the <see cref="E:System.Windows.Forms.Form.Load"/> event.
    /// </summary>
    /// <param name="e">An <see cref="T:System.EventArgs"/> that contains the event data. </param>
    protected override void OnLoad(EventArgs e)
    {
      base.OnLoad(e);

      iPolyominoViewer.Shape = Tetrominoes.I;
      jPolyominoViewer.Shape = Tetrominoes.J;
      lPolyominoViewer.Shape = Tetrominoes.L;
      oPolyominoViewer.Shape = Tetrominoes.O;
      sPolyominoViewer.Shape = Tetrominoes.S;
      tPolyominoViewer.Shape = Tetrominoes.T;
      zPolyominoViewer.Shape = Tetrominoes.Z;
    }

    private void closeButton_Click(object sender, EventArgs e)
    {
      this.Close();
    }

    private void cyotekLinkLabel_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
    {
      try
      {
        Process.Start("http://www.cyotek.com");
      }
      catch (Exception ex)
      {
        MessageBox.Show($"Failed to open URL. {ex.GetBaseException(). Message}", this.Text, MessageBoxButtons.OK,
                        MessageBoxIcon.Exclamation);
      }
    }

    private void rotationTimer_Tick(object sender, EventArgs e)
    {
      if (clockwiseRadioButton.Checked)
      {
        iPolyominoViewer.Shape = iPolyominoViewer.Shape.RotateClockwise(907);
        jPolyominoViewer.Shape = jPolyominoViewer.Shape.RotateClockwise(60);
        lPolyominoViewer.Shape = lPolyominoViewer.Shape.RotateClockwise(123);
        oPolyominoViewer.Shape = oPolyominoViewer.Shape.RotateClockwise(6);
        sPolyominoViewer.Shape = sPolyominoViewer.Shape.RotateClockwise(76);
        tPolyominoViewer.Shape = tPolyominoViewer.Shape.RotateClockwise(10);
        zPolyominoViewer.Shape = zPolyominoViewer.Shape.RotateClockwise(15);
      }
      else
      {
        iPolyominoViewer.Shape = iPolyominoViewer.Shape.RotateAntiClockwise();
        jPolyominoViewer.Shape = jPolyominoViewer.Shape.RotateAntiClockwise();
        lPolyominoViewer.Shape = lPolyominoViewer.Shape.RotateAntiClockwise();
        oPolyominoViewer.Shape = oPolyominoViewer.Shape.RotateAntiClockwise();
        sPolyominoViewer.Shape = sPolyominoViewer.Shape.RotateAntiClockwise();
        tPolyominoViewer.Shape = tPolyominoViewer.Shape.RotateAntiClockwise();
        zPolyominoViewer.Shape = zPolyominoViewer.Shape.RotateAntiClockwise();
      }
    }

    private void speedTrackBar_Scroll(object sender, EventArgs e)
    {
      rotationTimer.Interval = speedTrackBar.Value;
    }

    #endregion
  }
}
