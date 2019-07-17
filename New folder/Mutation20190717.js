//const bcrypt = require('bcryptjs')

//const { APP_SECRET, getUserId } = require('./Utils')
const bcrypt = require('../../node_modules/bcryptjs')
const jwt = require('../../node_modules/jsonwebtoken')
const { APP_SECRET, getUserId } = require('./Utils')

async function signup(parent, args, context, info) {

    //const password = await bcrypt.hash(args.password, 10)
	const password = (args.password)
    const user = await context.prisma.createUser({ ...args, password })
    //const token = jwt.sign({ userId: user.id }, APP_SECRET)
	const token = ({ userId: user.id })
    return {
        token,
        user,
    }
}

async function login(parent, args, context, info) {
	/*
	return context.db.mutation.createLomba({data:{
    lomba: args.lomba,
	ketlomba: args.ketlomba,
    }}, info)*/
    //const user = await context.db.prisma.user({ email: args.email })
	//const passwordx = await bcrypt.hash(args.password, 10)
	/*return context.db.mutation.login({data:{
    email: args.email,
	password: args.password,
    }}, info)*/

	const user = await context.db.query.users({where:{ email: args.email }}, '{id nama alamat email nohp biografi password}', info)
	//const password = await context.db.query.users({where:{ data: {email: args.email} }}, `{ password }`, info)
	//const userid = await context.db.query.users({where:{ email: args.email }}, `{ id }`)
    
    if (!user) {
        throw new Error('No such user found')
    }
	
	//const passx= await bcrypt.compareSync(user.password, hash)
	const userx = user[0]
	const idx= user[0].id
	const namax= user[0].nama
	const alamatx= user[0].alamat
	const emailx= user[0].email
	const nohpx= user[0].nohp
	const biografix= user[0].biografi
	const passwordx= user[0].password
	
	//const userx = JSON.stringify(user[0]);
	//const usery = JSON.toJSON(userx);
	//const userx = toJSON(user[0]);
	console.log("passwords match!", userx);
	
    const valid = await bcrypt.compare(args.password, user[0].password)
	//const valid = await bcrypt.compare(args.password, passx)
    if (!valid) {
       throw new Error('Invalid password')
	   
    }
	//const passnyo = user.password
    const token = jwt.sign({ userId: user[0].id }, APP_SECRET)
	//const token = ({ userId: user.id })
	console.log ( 'Type Data : ', typeof userx)
	
    /*return {data{
		token: token,
		user: userx
	}
    }
	*/
	return context.db.mutation.createAuthPayload({data:{
	token: token,
	//user: {connect: {id:idx, nama:namax, alamat:alamatx, email:emailx, nohp:nohpx, biografi:biografix, password:passwordx}},
	user: {connect: {id:idx}}
    }}, info)
	
}


async function createComment(parent, args, context, info) {
    const userId = getUserId(context)

    return context.prisma.createComment({
        createdAt: args.timeStamp,
        text: args.text,
        writtenBy: { connect: { id: userId } },
    })
}

/*
async function createLomba (context, { lomba, ketlomba }) {
      return context.prisma.createLomba({
        lomba,
        ketlomba,
      })
		}
		*/

async function createUser(parent, args, context, info) {
    const passwordx = await bcrypt.hash(args.password, 10)
		
	return context.db.mutation.createUser({data:{
    nama: args.nama,
	alamat: args.alamat,
	email: args.email,
	nohp: args.nohp,
	biografi: args.biografi,
	password: passwordx,
    }}, info)
}
	
async function createLomba(parent, args, context, info) {
    //const userId = getUserId(context)
	//return context.db.query.lombas({ }, info)
	
    //return context.db.mutation.createLomba(
	//{lomba: args.lomba,
		//ketlomba: args.ketlomba }, info)
		
	return context.db.mutation.createLomba({data:{
    lomba: args.lomba,
	ketlomba: args.ketlomba,
    }}, info)
}




async function createDiskusi(parent, args, context, info) {
    /*
	const userId = getUserId(context)

    return context.prisma.createDiskusi({
        createdAt: args.timeStamp,
        judul: args.judul,
		isi: args.isi,
		writtenBy: { connect: { id: userId } },
    })
	*/
	return context.db.mutation.createDiskusi({data:{
    judul: args.judul,
	isi: args.isi,
    }}, info)
}


async function createBerita(parent, args, context, info) {
   
	return context.db.mutation.createBerita({data:{
    headline: args.headline,
	berita: args.berita,
    }}, info)
}

module.exports = {
    signup,
    login,
	createComment,
	createLomba,
	createDiskusi,
	createBerita,
	createUser
}


