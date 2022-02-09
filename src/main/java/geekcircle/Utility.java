package com.geekcircle;

//Matrix type, Row , Col
public class Utility <T,U,V> {

    final Class<T> typeParameterClass;

    public Utility(){
        this(null);
    }

    public Utility(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public void printMatrix(T[][] arr, U[] u, V[] v){
        System.out.print("\t\t");
        for(int i = 0; i < v.length; i++){
            System.out.print(v[i]+"\t");
        }
        System.out.println();
        System.out.print("\t");
        for (int i = 0 ; i < arr.length; i++){
            if(i != 0){
                System.out.print(u[i-1]+ "\t");
            }
            for(int j = 0; j < arr[0].length; j++){
                if(typeParameterClass != null && typeParameterClass == Boolean.class){
                    System.out.print((((Boolean)arr[i][j]) ? "T":"F")+ "\t");
                } else {
                    System.out.print(arr[i][j]+ "\t");
                }
            }
            System.out.println();
        }
    }
}
