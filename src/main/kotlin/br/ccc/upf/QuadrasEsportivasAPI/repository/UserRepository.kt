package br.ccc.upf.QuadrasEsportivasAPI.repository

import br.ccc.upf.QuadrasEsportivasAPI.model.User
import org.springframework.stereotype.Repository


@Repository
class UserRepository(private var listUsers: MutableList<User>){

    private var idCont = 4L

    init {
        val admin = User(
            id = idCont++,
            city = "Passo Fundo",
            phone = "(054) 99112-2046",
            email = "168238@upf.br",
            name = "ADMIN",
            password = "168238"
        )

        listUsers = mutableListOf(admin)
    }

    fun findAll() = listUsers


    fun create(user: User) : User{
        val userWithId = user.copy(id = idCont++)
        listUsers.add(userWithId)
        return userWithId
    }

    fun update(user: User, newUser: User):User{
        listUsers.remove(user)
        val userWithId = User(
            id = user.id,
            name = newUser.name,
            email = newUser.email,
            phone = newUser.phone,
            city = newUser.city,
            password = newUser.password
        )

        return userWithId
    }

    fun delete(id: Long){
        val user = listUsers.firstOrNull{it.id==id}

        listUsers.remove(user)
    }
}
