package com.example.quizapp

class Constans {
    companion object{
        fun getqustions():ArrayList<Quiz>
        {
            var qustionslist = ArrayList<Quiz>()
            val question1 = Quiz(
                1, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_argentina,
                "ایران", "عربستان", "ترکیه", "آرژانتین", 4
            )

            val question2 = Quiz(
                2, "این پرچم متعلق به چه کشوری است  ؟", R.drawable.ic_flag_of_brazil,
                "آمریکا", "برزیل", "افغانستان", "آرژانتین", 2
            )

            val question3 = Quiz(
                3, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_india,
                "فرانسه", "دانمارک", "ترکیه", "هند", 4
            )

            val question4 = Quiz(
                4, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_germany,
                "ایران", "آلمان", "ترکیه", "آرژانتین", 2
            )

            val question5 = Quiz(
                5, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_denmark,
                "ایران", "دانمارک", "ترکیه", "آرژانتین", 2
            )

            val question6 = Quiz(
                6, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_new_zealand,
                "نیوزیلند", "دانمارک", "ترکیه", "آرژانتین", 1
            )

            val question7 = Quiz(
                7, "این پرچم متعلق به چه کشوری است  ؟‌", R.drawable.ic_flag_of_kuwait,
                "ایران", "دانمارک", "کویت", "آرژانتین", 3
            )
            qustionslist.add(question1)
            qustionslist.add(question2)
            qustionslist.add(question3)
            qustionslist.add(question4)
            qustionslist.add(question5)
            qustionslist.add(question6)
            qustionslist.add(question7)
            return qustionslist
        }
    }
}