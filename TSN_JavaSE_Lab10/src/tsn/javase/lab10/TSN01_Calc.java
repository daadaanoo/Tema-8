package tsn.javase.lab10;

import java.util.Arrays; // Библиотека работы с массивами
import static java.lang.Math.*; // Импорт всех математических функций

public class TSN01_Calc { // КЛАСС ВЫЧИСЛЕНИЯ ЗНАЧЕНИЙ

    int[] InMass; // Переменная для входного массива целых чисел
    double[] OutMass; // Переменная для выходного массива вещественных чисел
    int length_OrigMass; // Переменная для длины исходного массива

    public void SetMass(int OrigMass[]) { // МЕТОД ДЛЯ ЗАДАНИЯ ИСХОДНЫХ ДАННЫХ
        length_OrigMass = OrigMass.length; // Определяем длину исходного массива
        // Копируем значения из исходного массива во входной
        InMass = Arrays.copyOf(OrigMass, length_OrigMass);
        OutMass = new double[length_OrigMass]; // Создаем выходной массив
    }

    public double[] GetMass() { // МЕТОД ВЫЧИСЛЕНИЯ ЗНАЧЕНИЯ
        int ki, ki1;
        double pr = 1, sum = 0, fk = 1;
        for (int i = 0; i < length_OrigMass; i++) { // Цикл по элементам входного массива
            try {
                fk *= (i + 1); // Расчет факториала
                ki = InMass[i]; // Текущее значение элемента входного массива
                pr *= ki; // Расчет произведения элементов входного массива
                sum += ki; // Расчет суммы элементов входного массива
                ki1 = InMass[i - 1]; // Предыдущее значение элемента входного массива
                // Вычисление элемента для выходного массива по заданному алгоритму
                OutMass[i] = (cbrt((cos(ki1))
                        + 1.0/5 * (tan(ki/ki1))))
                        / sum;
            } catch (Exception ex) {
                OutMass[i] = Double.NaN; // Присваиваем значение элементу "нет решения"
            }
        }
        return OutMass; // Возвращаем результирующий массив в программу
    }
}
