class ImoocClassGroovy {
    def name = "imooc"
    // 只读 property
    final Date date = new Date()

    void printHello() {
        println("groovy imooc!!!!");
    }
}

ImoocClassGroovy demo = new ImoocClassGroovy(name:"Groovy")
println("Hello ${demo.name}")
println("${demo.printHello()}")

