/*EXPERIMENT : 07
Name : Shrusti Moon
Roll no : UEC2024145

Expt 7: Develop a program to model a single link list as stack
*/
#include <stdio.h>
#include <stdlib.h>

struct stack {
    int number;
    struct stack* next;
};

struct stack* top = NULL;

// Push operation
void push(int num) {
    struct stack* p = (struct stack*)malloc(sizeof(struct stack));
    if (p == NULL) {
        printf("Memory Allocation Failed!\n");
        return;
    }
    p->number = num;
    p->next = top;
    top = p;
    printf("%d pushed onto the stack.\n", num);
}

// Pop operation
int pop() {
    if (top == NULL) {
        printf("Stack Empty\n");
        return -9999;
    }
    struct stack* p = top;
    int x = p->number;
    top = top->next;
    free(p);
    printf("%d popped from the stack.\n", x);
    return x;
}

// Display stack
void display() {
    if (top == NULL) {
        printf("Stack is Empty!\n");
        return;
    }
    struct stack* temp = top;
    printf("Stack Elements: ");
    while (temp != NULL) {
        printf("%d ", temp->number);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    int choice, num;

    while (1) {
        printf("\n-----------------------------\n");
        printf("STACK MENU:\n");
        printf("1. PUSH\n");
        printf("2. POP\n");
        printf("3. EXIT\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter the number to push: ");
                scanf("%d", &num);
                push(num);
                display();
                break;

            case 2:
                pop();
                display();
                break;

            case 3:
                printf("Exiting Program...\n");
                exit(0);

            default:
                printf("Invalid choice! Try Again\n");
        }
    }
    return 0;
}
/*OUTPUT :
-----------------------------
STACK MENU:
1. PUSH
2. POP
3. EXIT
Enter your choice: 1
Enter the number to push: 3
3 pushed onto the stack.
Stack Elements: 3

-----------------------------
STACK MENU:
1. PUSH
2. POP
3. EXIT
Enter your choice: 1
Enter the number to push: 6
6 pushed onto the stack.
Stack Elements: 6 3

-----------------------------
STACK MENU:
1. PUSH
2. POP
3. EXIT
Enter your choice: 1
Enter the number to push: 7
7 pushed onto the stack.
Stack Elements: 7 6 3

-----------------------------
STACK MENU:
1. PUSH
2. POP
3. EXIT
Enter your choice: 1
Enter the number to push: 5
5 pushed onto the stack.
Stack Elements: 5 7 6 3

-----------------------------
STACK MENU:
1. PUSH
2. POP
3. EXIT
Enter your choice: 1
Enter the number to push: 8
8 pushed onto the stack.
Stack Elements: 8 5 7 6 3

-----------------------------
STACK MENU:
1. PUSH
2. POP
3. EXIT
Enter your choice: 2
8 popped from the stack.
Stack Elements: 5 7 6 3

-----------------------------
STACK MENU:
1. PUSH
2. POP
3. EXIT
Enter your choice: 3
Exiting Program...
*/