package com.example.myapplication19.view.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication19.Film
import com.example.myapplication19.R
import com.example.myapplication19.data.ApiConstants
import com.example.myapplication19.databinding.FilmItemBinding

//в параметр передаем слушатель, чтобы мы потом могли обрабатывать нажатия из класса Activity
class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<FilmListRecyclerAdapter.FilmsViewHolder>() {
    //Здесь у нас хранится список элементов для RV
    val items = mutableListOf<Film>()
    private lateinit var binding: FilmItemBinding

    //Этот метод нужно переопределить на возврат количества элементов в списке RV
    override fun getItemCount() = items.size

    //В этом методе мы привязываем наш ViewHolder и передаем туда "надутую" верстку нашего фильма
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {

            binding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //return FilmViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false))
        return FilmsViewHolder(binding)
    }

    //В этом методе будет привязка полей из объекта Film к View из film_item.xml
    //override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {


        //Проверяем какой у нас ViewHolder
        when (holder) {
            is FilmsViewHolder -> {
                //Вызываем метод bind(), который мы создали, и передаем туда объект
                //из нашей базы данных с указанием позиции


                holder.bind(items[position])
                //Обрабатываем нажатие на весь элемент целиком(можно сделать на отдельный элемент
                //например, картинку) и вызываем метод нашего листенера, который мы получаем из
                //конструктора адаптера


               val animation = AnimationUtils.loadAnimation(binding.root.context, R.anim.myanim)
               holder.binding.ratingDonut.startAnimation(animation)

               holder.itemView.findViewById<CardView>(R.id.item_container).setOnClickListener {
                    clickListener.click(items[position])
                }

            }
        }
    }

    //Метод для добавления объектов в наш список
    fun addItems(list: List<Film>) {
        //Сначала очищаем(если не реализовать DiffUtils)
        items.clear()
        //Добавляем
        items.addAll(list)
        //Уведомляем RV, что пришел новый список, и ему нужно заново все "привязывать"
        notifyDataSetChanged()
    }


    //Интерфейс для обработки кликов
    interface OnItemClickListener {
        fun click(film: Film)
    }

    //inner class FilmsViewHolder(val binding:  FilmItemBinding):RecyclerView.ViewHolder(binding.root)
    inner class FilmsViewHolder(val binding:  FilmItemBinding):RecyclerView.ViewHolder(binding.root)
    {
        //Привязываем View из layout к переменным
        private val title = binding.title
        private val poster = binding.poster
        private val description = binding.description
        private val ratingDonut = binding.ratingDonut
        //В этом методе кладем данные из Film в наши View
        fun bind(film: Film) {
            //Устанавливаем заголовок
            title.text = film.title
            //Устанавливаем постер
            //Указываем контейнер, в котором будет "жить" наша картинка
            //Glide.with(itemView)
            Glide.with(binding.root)
                //Загружаем сам ресурс
                //.load(film.poster)
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


}