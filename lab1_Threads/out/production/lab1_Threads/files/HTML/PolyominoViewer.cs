// Rotating an array using C#
// http://www.cyotek.com/blog/rotating-an-array-using-csharp

using System;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;

namespace CyotekDotComRotateArrayDemo
{
  internal sealed class PolyominoViewer : Control
  {
    #region Fields

    private Polyomino _shape;

    private int _tileSize;

    #endregion

    #region Constructors

    public PolyominoViewer()
    {
      this.SetStyle(
                    ControlStyles.AllPaintingInWmPaint | ControlStyles.DoubleBuffer |
                    ControlStyles.OptimizedDoubleBuffer | ControlStyles.ResizeRedraw, true);
      this.SetStyle(ControlStyles.Selectable, false);

      this.BackColor = SystemColors.ControlLight;
    }

    #endregion

    #region Static Methods

    private static void DrawCell(Graphics g, int x, int y, int w, int h)
    {
      g.FillRectangle(SystemBrushes.ControlDark, x, y, w, h);
      g.DrawRectangle(SystemPens.ControlDarkDark, x, y, w, h);
    }

    #endregion

    #region Properties

    /// <summary>
    /// Gets or sets the background color for the control.
    /// </summary>
    /// <returns>
    /// A <see cref="T:System.Drawing.Color"/> that represents the background color of the control. The default is the value of the <see cref="P:System.Windows.Forms.Control.DefaultBackColor"/> property.
    /// </returns>
    /// <PermissionSet><IPermission class="System.Security.Permissions.FileIOPermission, mscorlib, Culture=neutral, version= 1 Unrestricted="true"/></PermissionSet>
    [DefaultValue(typeof(Color), "ControlLight")]
    public override Color BackColor
    {
      get { return base.BackColor; }
      set { base.BackColor = value; }
    }

    [Browsable(false)]
    [DesignerSerializationVisibility(DesignerSerializationVisibility.Hidden)]
    public Polyomino Shape
    {
      get { return _shape; }
      set
      {
        _shape = value;

        this.Invalidate();
      }
    }

    #endregion

    #region Methods

    /// <summary>
    /// Raises the <see cref="E:System.Windows.Forms.Control.Paint"/> event.
    /// </summary>
    /// <param name="e">A <see cref="T:System.Windows.Forms.PaintEventArgs"/> that contains the event data. </param>
    protected override void OnPaint(PaintEventArgs e)
    {
      Polyomino shape;
      bool[] matrix;

      base.OnPaint(e);

      e.Graphics.Clear(this.BackColor);
      ControlPaint.DrawBorder(e.Graphics, this.ClientRectangle, Border3DStyle.Sunken);

      shape = this.Shape;
      matrix = shape.Matrix;

      if (matrix != null && matrix.Length != 0)
      {
        int sx;
        int sy;
        Size size;

        size = this.ClientSize;
        sx = (size.Width - shape.Width * _tileSize) / 2;
        sy = (size.Height - shape.Height * _tileSize) / 2;

        for (int row = 0; row < shape.Height; row++)
        {
          for (int col = 0; col < shape.Width; col++)
          {
            int index;

            index = row * shape.Width + col;

            if (matrix[index])
            {
              int x;
              int y;

              y = sy + row * _tileSize;
              x = sx + col * _tileSize;

              DrawCell(e.Graphics, x, y, _tileSize, _tileSize);
            }
          }
        }
      }
    }

    /// <summary>
    /// Raises the <see cref="E:System.Windows.Forms.Control.Resize"/> event.
    /// </summary>
    /// <param name="e">An <see cref="T:System.EventArgs"/> that contains the event data. </param>
    protected override void OnResize(EventArgs e)
    {
      Size size;

      base.OnResize(e);

      size = this.ClientSize;

      if (size.Width > size.Height)
      {
        _tileSize = size.Height / 6;
      }
      else
      {
        _tileSize = size.Width / 6;
      }
    }

    #endregion
  }
}
