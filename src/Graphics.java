public class Graphics {

//Bomb = Röda kryss (X)
// 0 = Undersökt ruta utan bomber runtom sig.
// 1+ = Visar hur många antal bomber det finns bredvid en ruta.
// F = Flagga
//
//
//
//        System.out.println("_____________________________________________________________");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |  X  |  1  |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |  0  |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");


//         System.out.println("_____________________________________________________________");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");




















//        System.out.println("|     |     |     |     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|_____|_____|_____|_____|_____|_____|_____|");
//
//
//
//        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|  x  |  0  |     |     |     |     |     |");
//        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("|     |     |     |     |     |     |     |");
//        System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
//








}
