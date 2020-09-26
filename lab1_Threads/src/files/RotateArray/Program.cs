// Rotating an array using C#
// http://www.cyotek.com/blog/rotating-an-array-using-csharp

using System;
using System.Windows.Forms;

namespace CyotekDotComRotateArrayDemo
{
  internal static class Program
  {
    #region Static Methods

    /// <summary>
    /// The main entry point for the application.
    /// </summary>
    [STAThread]
    static void Main()
    {
      Application.EnableVisualStyles();
      Application.SetCompatibleTextRenderingDefault(false);
      Application.Run(new MainForm());
    }

    #endregion
  }
}
