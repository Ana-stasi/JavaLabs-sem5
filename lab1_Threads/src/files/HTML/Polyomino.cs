// Rotating an array using C#

using System;

namespace CyotekDotComRotateArrayDemo
{
  internal struct Polyomino
  {
    #region Constructors

    public Polyomino(bool[] matrix, byte width, byte height)
    {
      int length;

      if (width < 1)
      {
        throw new ArgumentException("Width must be greater than zero.", nameof(width));
      }

      if (height < 1)
      {
        throw new ArgumentException("Height must be greater than zero.", nameof(height));
      }

      if (matrix == null)
      {
        throw new ArgumentNullException(nameof(matrix));
      }

      length = width * height;

      if (matrix.Length != length)
      {
        throw new ArgumentException($"Matrix must contain {length} elements.", nameof(matrix));
      }

      this.Matrix = matrix;
      this.Width = width;
      this.Height = height;
    }

    #endregion

    #region Properties

    public byte CenterX
    {
      get { return (byte)(this.Width / 2); }
    }

    public byte CenterY
    {
      get { return (byte)(this.Height / 2); }
    }

    public byte Height { get; }

    public bool[] Matrix { get; }

    public byte Width { get; }

    #endregion

    #region Methods

    public Polyomino RotateAntiClockwise()
    {
      return this.Rotate(false);
    }

    public Polyomino RotateClockwise()
    {
      return this.Rotate(true);
    }

    private Polyomino Rotate(bool clockwise)
    {
      int width;
      int height;
      bool[] result;
      bool[] matrix;

      matrix = this.Matrix;
      width = this.Width;
      height = this.Height;
      result = new bool[matrix.Length];

      for (int row = 0; row < height; row++)
      {
        for (int col = 0; col < width; col++)
        {
          int index;

          index = row * width + col;

          if (matrix[index])
          {
            int newRow;
            int newCol;
            int newIndex;

            if (clockwise)
            {
              newRow = col;
              newCol = height - (row + 1);
            }
            else
            {
              newRow = width - (col + 1);
              newCol = row;
            }

            newIndex = newRow * height + newCol;

            result[newIndex] = true;
          }
        }
      }

      return new Polyomino(result, this.Height, this.Width);
    }

    #endregion
  }
}
