# Description
ImageCode is an open source projet that transform an image into code. ImageCode is devided into two parts: 
1. IC Brain Engine
2. IC Code Engine
## Example

### Here's the generated code:
```javascript
import React, { Component } from 'react';
import { button, View } from 'react-native';

export default class ImageCode extends Component {
render() {
    return (
        <View style={{
            Width:200,
            Height:50
         }}>
          <button style={{
            Width:20,
            Height:100
          }}>
             button
          </button>
          </View>);}}
```
# Contributing to Image-Code-Engine
First of all, thank you for taking the time to contribute! 👍 🎉
## How to Contribute
### Discuss
If you have a question, join us on [#imagecode](https://agile-irb-bnp.slack.com/messages/CCJFHDRDK/) on slack. you find related issues and discussions. You can, also, ask us any questions, you are welcome. This helps us to improve the project.
### Steps to contribution 
### Step 1: Fork the project & clone locally
You can fork the project by pressing the “fork” button on Github. This will create a copy of the repository in your own GitHub account. 
Now you need a copy locally, so find the “SSH clone URL” in the right hand column and use that to clone locally using a terminal.
### Step 2: Create an upstream remote and sync your local copy before you branch
Change into the new project’s directory.
```
cd ImageCode/
```
Now, you need to set up a new remote that points to the original project so that you can grab any changes and bring them into your local copy. 
```
$ git remote add upstream https://github.com/marocraft/ImageCode
```
You now have two remotes for this project on disk:
1.	origin which points to your GitHub fork of the project. You can read and write to this remote.
2.	upstream which points to the main project’s GitHub repository. You can only read from this remote.
### Step 3: Branch for each separate piece of work
The number one rule is to put each piece of work on its own branch.
The general rule is that if you are bug fixing, then branch from master and if you are adding a new feature then branch from develop. 
You can name your branch whatever you like, but it helps for it to be meaningful. 
```
$ git checkout -b feature/refactoring
```
### Step 4: Do the work, write good commit messages
Ensure that you only fix the thing you’re working on. Do not be tempted to fix some other things that you see along the way, including formatting issues, as your PR will probably be rejected.
Make sure that you commit in logical blocks. Each commit message should be sane. 

### Step 5: Push to your origin repository
```
$ git push -u origin feature/refactoring
```
Once you push your branch to the origin remote, you can swap  back to the browser and navigate to your fork and you’ll see that your new branch is listed at the top with a handy “Compare & pull request” button.
Go ahead and press the button.





