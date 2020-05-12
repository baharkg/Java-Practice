# Programming in Python
# Sharif University of Technology
# Instructor: Hamid Zarrabi-Zadeh

# Project - Phase 2
# Mine Sweeper


import random
from tkinter import *
from tkinter import simpledialog, messagebox


# global variables
global size, mines_count, time  # data
global mines_label, time_label  # labels


# global tables
board = []  # board table
mines = []  # mines table
cells = []  # cells table


#----------------------------------
# Code for Phase 1 of Project
#----------------------------------


def create_board(board_size, num_mines):
    ''' Create a random board of given size with given number of mines '''
    global size, mines_count
    mines_count = num_mines
    size = board_size

    for i in range(size):
        board.append([0] * size)
        mines.append([0] * size)

    i = 0
    while i < num_mines:
        x = random.randrange(size)
        y = random.randrange(size)
        if mines[x][y] == 0:
            mines[x][y] = 1
            i += 1


def toggle_flag(row, col):
    ''' Put a flag on the given cell, or remove it if it already exists '''

    # put flag
    if board[row][col] == 0:
        board[row][col] = 2
        cells[row][col]['text'] = 'P'

    # remove flag
    elif board[row][col] == 2:
        board[row][col] = 0
        cells[row][col]['text'] = ' '


def count_mines(row, col):
    ''' Count the number of mines in cells adjacent to a given cell '''
    count = 0
    for i in range(-1, 2):
        for j in range(-1 , 2):
            x = row + i
            y = col + j
            if not(i == 0 and j == 0) and 0 <= x < size and 0 <= y < size and mines[x][y] == 1:
                count += 1
    return count


def won():
    ''' Check if the player has won or not '''
    for i in range(size):
        for j in range(size):
            if mines[i][j] == 0 and board[i][j] != 1 or mines[i][j] == 1 and board[i][j] != 2:
                return False
    return True


#----------------------------------
# Code for Phase 2 of Project
#----------------------------------


def click_cell(row, col):
    ''' Handle clicking on a cell.
        If it is a mine, finish the game; player will loose.
        If it has a flag, do nothing.
        Otherwise, show the number of mines around the cell.
    '''
    pass


def init_gui(master):
    ''' Initialize the graphical user interface '''
    global mines_label, mines_count, time_label

    master.title('MineSweeper')
    master.minsize(size * 30 + 40, size * 30 + 70)

    frame = Frame(master)
    frame.grid(padx = 30, pady = 30)

    for i in range(size):
        cells.append([])

    for i in range(size):
        for j in range(size):
            cell = Button(frame, text = '     ', bg = '#DDDDDD')
            cell.config(anchor = CENTER)
            cell.grid(row = i, column = j, sticky = 'nswe')
            cells[i].append(cell)

            def left_click_handler(event, row = i, col = j):
                click_cell(row, col)

            def right_click_handler(event, row = i, col = j):
                toggle_flag(row, col)

            cell.bind('<Button-3>', right_click_handler)
            cell.bind('<Button-1>', left_click_handler)

    remainings = Label(frame, text = 'Mines: ')
    remainings.grid(row = size + 1, column = 1, columnspan = 2, pady = 10)

    mines_label = Label(frame, text = mines_count)
    mines_label.grid(row = size + 1, column = 3, pady = 0)

    timer = Label(frame, text = 'Time :')
    timer.grid(row = size + 2, column = 1, columnspan = 2, pady = 0)

    time_label = Label(frame, text = '0')
    time_label.grid(row = size + 2, column = 3, pady = 0)

    master.deiconify()


def main():
    ''' The main entry of the game '''
    root = Tk()
    root.withdraw()

    # init board size and mines count
    board_size = 5
    mines_count = 5
    create_board(board_size, mines_count)

    init_gui(root)
    root.mainloop()


# Entry Point
main()
