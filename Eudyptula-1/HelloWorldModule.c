#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/init.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Ulrich Buschbaum");
MODULE_DESCRIPTION("Hello World Linux Kernel Module");

int init_module(void) {
    printk(KERN_DEBUG "Hello world from my first Linux Kernel Module!\n");
    return 0;
}

void cleanup_module(void) {
    printk(KERN_DEBUG "Good-by from my first Linux Kernel Module!\n");
}
