using System;
    class Rectangle
    {
        protected double length;
        protected double width;
        public Rectangle(double l, double w)
        {
            length = l;
            width = w;
        }
        public double GetArea()
        {
            return length * width;
        }
        public void Display()
        {
            Console.WriteLine("Length: {0}", length);
            Console.WriteLine("Width: {0}", width);
            Console.WriteLine("Area: {40}", GetArea());
        }
    } 
    class Tabletop : Rectangle
    {
        private double cost;
        public Tabletop(double l, double w)
            : base(l, w)
        { }
        public double costcal()
        {
            double cost;
            cost = GetArea() * 70;
            return cost;
        }
        public void Display()
        {
            base.Display();
            Console.WriteLine("Cost: {0}", costcal());
        }
    }
    class CalRectangle
    {
        static void Main(string[] args)
        {
            Tabletop t = new Tabletop(455, 990);
            t.Display();
            Console.ReadLine();
        }
    }