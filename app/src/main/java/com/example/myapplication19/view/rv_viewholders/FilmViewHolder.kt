package com.example.myapplication19.view.rv_viewholders

import com.bumptech.glide.Glide
import com.example.myapplication19.Film
import com.example.myapplication19.databinding.FilmItemBinding


//В конструктор класс передается layout, который мы создали(film_item.xml)
// передает binding
class FilmViewHolder(private val binding:  FilmItemBinding)  {

    //Привязываем View из layout к переменным
    private val title = binding.title
    private val poster = binding.poster
    private val description = binding.description
    private val ratingDonut = binding.ratingDonut
   // private val title = itemView.findViewById<TextView>(R.id.title)
   // private val poster = itemView.findViewById<ImageView>(R.id.poster)
   // private val description = itemView.findViewById<TextView>(R.id.description)
   //Вот здесь мы находим в верстке наш прогресс бар для рейтинга
   // private val ratingDonut = itemView.findViewById<View>(R.id.rating_donut)


    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {
        //Устанавливаем заголовок
        title.text = film.title
        //Устанавливаем постер
        //Указываем контейнер, в котором будет "жить" наша картинка
        //Glide.with(itemView)
        Glide.with(binding.root)
           //Загружаем сам ресурс
            .load(film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(poster)
        //Устанавливаем описание
        description.text = film.description
        //Устанавливаем рэйтинг
        ratingDonut.setProgress((film.rating * 10).toInt())
    }

}