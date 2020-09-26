// Rotating an array using C#
// http://www.cyotek.com/blog/rotating-an-array-using-csharp

namespace CyotekDotComRotateArrayDemo
{
  internal static class Tetrominoes
  {
    #region Constants

    public static readonly Polyomino I = new Polyomino(new[]
                                                       {
                                                         true,
                                                         true,
                                                         true,
                                                         true
                                                       }, 1, 4);

    public static readonly Polyomino J = new Polyomino(new[]
                                                       {
                                                         false,
                                                         true,
                                                         false,
                                                         true,
                                                         true,
                                                         true
                                                       }, 2, 3);

    public static readonly Polyomino L = new Polyomino(new[]
                                                       {
                                                         true,
                                                         false,
                                                         true,
                                                         false,
                                                         true,
                                                         true
                                                       }, 2, 3);

    public static readonly Polyomino O = new Polyomino(new[]
                                                       {
                                                         true,
                                                         true,
                                                         true,
                                                         true
                                                       }, 2, 2);

    public static readonly Polyomino S = new Polyomino(new[]
                                                       {
                                                         false,
                                                         true,
                                                         true,
                                                         true,
                                                         true,
                                                         false
                                                       }, 3, 2);

    public static readonly Polyomino T = new Polyomino(new[]
                                                       {
                                                         true,
                                                         true,
                                                         true,
                                                         false,
                                                         true,
                                                         false
                                                       }, 3, 2);

    public static readonly Polyomino Z = new Polyomino(new[]
                                                       {
                                                         true,
                                                         true,
                                                         false,
                                                         false,
                                                         true,
                                                         true
                                                       }, 3, 2);

    #endregion
  }
}
