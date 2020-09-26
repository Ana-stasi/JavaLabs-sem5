using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
namespace Inheritance
{
    class Program
    {
        static void Main(string[] args)
        {
            Principal g = new Principal("21");
            g.Monitor();
            Teacher d = new Teacher("154");
            d.Monitor();
            d.Teach();
            Student s = new Student("11");
            s.Monitor();
            s.Learn();
            Console.ReadKey();
        }
        class Principal
        {
            public void Monitor()
            {
                Console.WriteLine("Monitor 1");
            }
        }
        class Teacher : Principal
        {
            public void Teach()
            {
                Console.WriteLine("Teach 678");
            }
        }
        class Student : Principal
        {
            public void Learn()
            {
                Console.WriteLine("23: Learn");
            }
        }
    }
}