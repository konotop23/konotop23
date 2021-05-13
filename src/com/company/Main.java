package com.company;

public class Main {

    public static void main(String[] args) {
	int [] mas = {5,2,4,6,1,3,2,6};
        System.out.println("Изначальный массив:");
        for (int j : mas)
            System.out.print(j + " ");
        System.out.println(" ");
        mas = sort(mas);
        System.out.println("Массив после сортировки:");
        for (int j : mas)
            System.out.print(j + " ");

    }

    //сортируем массив , который передается в функцию
    public static int[] sort (int[] array1){
        if (array1==null)//не нулевой ли массив ?
            return null;

        if(array1.length<2)//не 1 ли элемент в массиве ?
            return array1;

            int[] array2 = new int[array1.length/2];// копируем первую половину
            System.arraycopy(array1, 0, array2, 0, array1.length / 2);

            int[] array3 = new int[array1.length - array1.length / 2];//копируем вторую половину массива, вычитая из длины первую часть
            System.arraycopy(array1, array1.length / 2, array3, 0, array1.length - array1.length / 2);

            //с помощью рекурсии вызываем метод до тех пор , пока не дойдет до одного элемента в массиве
            array2 = sort(array2);
            array3 = sort(array3);

            return mergeArray(array2, array3);//рекурсия возврата слияния двух массивов

    }

    //функция слияния
    public static int[] mergeArray(int [] array1, int [] array2){
        int [] array3 = new int [array1.length + array2.length];
        int positionA = 0; int positionB = 0;//Чтобы не проходить многократно по каждому массиву, введем индексы позиции для каждого массива.

        for (int i = 0; i<array3.length; i++){
         if(positionA == array1.length){
             array3[i] = array2[positionB];
             positionB++;
         }else if( positionB == array2.length){
             array3[i] = array1[positionA];
             positionA++;
         } else if(array2[positionB]<array1[positionA]){
             array3[i] = array2[positionB];
             positionB++;
         } else {
             array3[i] = array1[positionA];
             positionA++;
         }
        }
        return  array3;
    }

}
