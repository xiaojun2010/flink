/*************
 *
 * Groovy 脚本
 *
 * 测试 Groovy 变量作用域:
 * a. 直接声明：相当于 public 共有变量, 即绑定作用域
 * b. 使用 def 声明：相当于 private 私有变量, 即本地作用域
 *
 *************/

//本地作用域
def name = "imooc_private"
//绑定作用域
name2 = "imooc_public"

println "$name"
println "$name2"


/*************
 *
 * 在函数中,
 * 可以使用绑定作用域变量,
 * 不能使用本地作用域
 *
 * 所以下面函数是会报错的
 *
 *************/
void printName() {
    println "$name"
    println "$name2"
}
printName()
